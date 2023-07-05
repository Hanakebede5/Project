<?php
// Include employeeDAO file
require_once('./dao/employeeDAO.php');

 
// Define variables and initialize with empty values
$text = $date = $salary = $image = "";
$text_err = $date_err = $salary_err = $image_err = "";
 
// Processing form data when form is submitted
if($_SERVER["REQUEST_METHOD"] == "POST"){
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
        $employeeDAO = new employeeDAO();    
        $employee = new Employee(0, $text, $date, $salary, $image);
        $addResult = $employeeDAO->addEmployee($employee);        
        header( "refresh:2; url=index.php" ); 
		echo '<br><h6 style="text-align:center">' . $addResult . '</h6>';   
        // Close connection
        $employeeDAO->getMysqli()->close();
    }
}
?>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Record</title>
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
                    <h2 class="mt-5">Create Record</h2>
                    <p>Please fill this form and submit to add employee record to the database.</p>
					
					<!--the following form action, will send the submitted form data to the page itself ($_SERVER["PHP_SELF"]), instead of jumping to a different page.-->
                    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" name="text" class="form-control <?php echo (!empty($text_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $text; ?>">
                            <span class="invalid-feedback"><?php echo $text_err;?></span>
                        </div>
                        <div class="form-group">
                            <label>Date</label>
                            <input type="text" name="date" class="form-control <?php echo (!empty($date_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $date; ?>">
                            <span class="invalid-feedback"><?php echo $date_err;?></span>
                        </div>
                        <div class="form-group">
                            <label>salary</label>
                            <textarea name="salary" class="form-control <?php echo (!empty($salary_err)) ? 'is-invalid' : ''; ?>"><?php echo $salary; ?></textarea>
                            <span class="invalid-feedback"><?php echo $salary_err;?></span>
                        </div>
                        <div class="form-group">
                            <label>Image</label>
                            <input type="file" name="image" />
                            <span class="invalid-feedback"><?php echo $image_err;?></span>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Submit">
                        <a href="index.php" class="btn btn-secondary ml-2">Cancel</a>
                    </form>
                </div>
            </div>        
        </div>
        <?include 'footer.php';?>
    </div>
</body>
</html>