<?php
// Include employeeDAO file
require_once('./dao/employeeDAO.php');

// Check if the employee ID is set and not empty
if(isset($_POST["id"]) && !empty($_POST["id"])){
    // Create a new employeeDAO object
    $employeeDAO = new employeeDAO();
    
    // Sanitize the employee ID input
    $employeeId = trim($_POST["id"]);        
    
    // Call the deleteEmployee method and check for errors
    $result = $employeeDAO->deleteEmployee($employeeId);
    if($result){
        // If successful, redirect to index.php
        header("location: index.php");
        exit();
    } else{
        // If not successful, display an error message
        echo "Oops! Something went wrong. Please try again later.";
    }
}

// Check if the ID parameter is set in the URL
if(isset($_GET["id"])){
    // Sanitize the ID input
    $employeeId = trim($_GET["id"]);
} else {
    // If ID parameter is not set, display an error message
    echo "Oops! Employee ID is not set.";
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Record</title>
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
                    <h2 class="mt-5 mb-3">Delete Record</h2>
                    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
                        <div class="alert alert-danger">
                            <input type="hidden" name="id" value="<?php echo $employeeId; ?>"/>
                            <p>Are you sure you want to delete this employee record?</p>
                            <p>
                                <input type="submit" value="Yes" class="btn btn-danger">
                                <a href="index.php" class="btn btn-secondary ml-2">No</a>
                            </p>
                        </div>
                    </form>
                </div>
            </div>        
        </div>
    </div>
</body>
</html>
