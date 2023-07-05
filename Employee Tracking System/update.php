<?php
// Include employeeDAO file
require_once('./dao/employeeDAO.php');
 
// Define variables and initialize with empty values
$text = $date = $salary= $image = "";
$text_err = $date_err = $salary_err = $image_err = "";
$employeeDAO = new employeeDAO(); 


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get hidden input value
    $id = $_POST["id"];

    // Validate name
    $input_text = trim($_POST["text"]);
    if(empty($input_text)){
        $text_err = "Please enter a text.";
    } elseif(!filter_var($input_text, FILTER_VALIDATE_REGEXP, array("options"=>array("regexp"=>"/^[a-zA-Z\s]+$/")))){
        $text_err = "Please enter a valid name.";
    } else{
        $text = $input_text;
    }
    
    // Validate date
    $input_date = trim($_POST["date"]);
    if(empty($input_date)){
        $date_err = "Please enter a date.";     
    } else{
        $date = $input_date;
    }

        
    // Validate salary
    $input_salary = trim($_POST["salary"]);
    if(empty($input_salary)){
        $salary_err = "Please enter a salary.";     
    } else{
        $salary = $input_salary ;
    }
    
    // Validate image
    $target_dir = "Images/";
    $file = $target_dir.basename($_FILES["image"]["name"]);;
    $input_image = basename($_FILES["image"]["name"]);
    if(empty($input_image)){
        $image_err = "Please upload the image file.";     
    } else{
       $checkImage = $_FILES['image']['size'];

       if($checkImage < 2097152){
           if(move_uploaded_file($_FILES["image"]["tmp_name"], $file)){
               $image = $target_dir.$input_image;
           }
           else{
               $image_err = "The image ". $input_image. " upload is unsuccessfull.";
           }
       } else{
        $image_err = "Please upload image file less that 2GB";
       }        
    } 
    
    // Check input errors before inserting in database
   if(empty($text_err) && empty($date_err) && empty($salary_err) && empty($image_err)){
    $employee = new employee($id, $text, $date,$salary,$image);
    $result = $employeeDAO->updateEmployee($employee); 
    if($result) {
       header("Location: index.php");
       exit();
    } else {
       echo "Something went wrong. Please try again later." . $result . '</h6>';
    } 
    // Close connection
}


} else{
    // Check existence of id parameter before processing further
    if(isset($_GET["id"]) && !empty(trim($_GET["id"]))){
        // Get URL parameter
        $id =  trim($_GET["id"]);
        $employee = $employeeDAO->getEmployee($id);
                
        if($employee){
            // Retrieve individual field value
            $text = $employee->getText();
            $date = $employee->getDate();
            $salary = $employee->getSalary();
            $image = $employee->getImage();
        } else{
            // URL doesn't contain valid id. Redirect to error page
            header("location: error.php");
            exit();
        }
    } else{
        // URL doesn't contain id parameter. Redirect to error page
        header("location: error.php");
        exit();
    }
    // Close connection
}
?>
 
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Record</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .wrapper{
            width: 600px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="mt-5">Update Record</h2>
                    <p>Please edit the input values and submit to update the employee record.</p>
                    <form action="<?php echo htmlspecialchars(basename($_SERVER['REQUEST_URI'])); ?>" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>text</label>
                            <input type="text" name="text" class="form-control <?php echo (!empty($text_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $text; ?>">
                            <span class="invalid-feedback"><?php echo $text_err;?></span>
                        </div>
                        <div class="form-group">
                            <label>Date</label>
                            <textarea name="date" class="form-control <?php echo (!empty($date_err)) ? 'is-invalid' : ''; ?>"><?php echo $date; ?></textarea>
                            <span class="invalid-feedback"><?php echo $date_err;?></span>
                        </div>
                        <div class="form-group">
                            <label>salary</label>
                            <input type="salary" name="salary" class="form-control <?php echo (!empty($salary_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $salary; ?>">
                            <span class="invalid-feedback"><?php echo $salary_err;?></span>
                        </div>
                        <div class="form-group">
                            <label>image</label>
                            <input type="file" name="image" class="form-control <?php echo (!empty($image_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $image; ?>">
                            <span class="invalid-feedback"><?php echo $image_err;?></span>
                        </div>
                        <input type="hidden" name="id" value="<?php echo $id; ?>"/>
                        <input type="submit" class="btn btn-primary" value="Submit">
                        <a href="index.php" class="btn btn-secondary ml-2">Cancel</a>
                    </form>
                </div>
            </div>        
        </div>
    </div>
</body>
</html>