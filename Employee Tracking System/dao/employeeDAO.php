
<?php
require_once('abstractDAO.php');
require_once('./model/employee.php');

class employeeDAO extends abstractDAO {
        
    function __construct() {
        try{
            parent::__construct();
        } catch(mysqli_sql_exception $e){
            throw $e;
        }
    }  
    
    public function getEmployee($employeeId){
        $query = 'SELECT * FROM employee2 WHERE id = ?';
        $stmt = $this->mysqli->prepare($query);
        $stmt->bind_param('i', $employeeId);
        $stmt->execute();
        $result = $stmt->get_result();
        if($result->num_rows == 1){
            $temp = $result->fetch_assoc();
            $employee = new Employee($temp['id'],$temp['text'], $temp['date'], $temp['salary'], $temp['image']);
            $result->free();
            return $employee;
        }
        $result->free();
        return false;
    }

    public function getEmployees(){
        $result = $this->mysqli->query('SELECT * FROM employee2');
        $employees = array();
        
        if($result->num_rows >= 1){
            while($row = $result->fetch_assoc()){
                $employee = new Employee($row['id'], $row['text'], $row['date'], $row['salary'],$row['image']);
                $employees[] = $employee;
            }
            $result->free();
            return $employees;
        } else {
            $result->free();
            return false;
        }
    }
    
    
    public function addEmployee($employee){
        
        if(!$this->mysqli->connect_errno){
            //The query uses the question mark (?) as a
            //placeholder for the parameters to be used
            //in the query.
            //The prepare method of the mysqli object returns
            //a mysqli_stmt object. It takes a parameterized 
            //query as a parameter.
			$query = 'INSERT INTO employee2 (text, date, salary, image) VALUES (?,?,?,?)';
			$stmt = $this->mysqli->prepare($query);
            if($stmt){
                    $text = $employee->getText();
			        $date = $employee->getDate();
			        $salary = $employee->getSalary();
                    $image = $employee->getImage();
                  
			        $stmt->bind_param('ssis', 
				        $text,
				        $date,
				        $salary,
                        $image
			        );    
                    //Execute the statement
                    $stmt->execute();         
                    
                    if($stmt->error){
                        return $stmt->error;
                    } else {
                        return $employee->getText() . ' added successfully!';
                    } 
			}
             else {
                $error = $this->mysqli->errno . ' ' . $this->mysqli->error;
                echo $error; 
                return $error;
            }
       
        }else {
            return 'Could not connect to Database.';
        }
    }   
    public function updateEmployee($employee){
        
        if(!$this->mysqli->connect_errno){
            //The query uses the question mark (?) as a
            //placeholder for the parameters to be used
            //in the query.
            //The prepare method of the mysqli object returns
            //a mysqli_stmt object. It takes a parameterized 
            //query as a parameter.
            $query = "UPDATE employee2 SET text=?, date=?, salary=?, image=? WHERE id=?";
            $stmt = $this->mysqli->prepare($query);
            if($stmt){
                    $id = $employee->getId();
                    $text = $employee->getText();
			        $date = $employee->getDate();
                    $salary = $employee->getSalary();
                    $image = $employee->getImage();
                  
			        $stmt->bind_param('ssisi', 
				        $text,
				        $date,
				        $salary,
                        $image,
                        $id
			        );    
                    //Execute the statement
                    $stmt->execute();         
                    
                    if($stmt->error){
                        return $stmt->error;
                    } else {
                        return $employee->getText() . ' updated successfully!';
                    } 
			}
             else {
                $error = $this->mysqli->errno . ' ' . $this->mysqli->error;
                echo $error; 
                return $error;
            }
       
        }else {
            return 'Could not connect to Database.';
        }
    }   

    public function deleteEmployee($employeeId){
        if(!$this->mysqli->connect_errno){
            $query = 'DELETE FROM employee2 WHERE id = ?';
            $stmt = $this->mysqli->prepare($query);
            $stmt->bind_param('i', $employeeId);
            $stmt->execute();
            if($stmt->error){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
?>