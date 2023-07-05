<?php
	class employee{		

		private $id;
		private $text;
		private $date;
		private $salary;
		private $image;

				
		function __construct($id, $text, $date,$salary,$image){
			$this->setId($id);
			$this->setText($text);
			$this->setDate($date);
			$this->setSalary($salary);
			$this->setImage($image);
			}		
		
		public function getText(){
			return $this->text;
		}
		
		public function setText($text){
			$this->text = $text;
		}
		
		public function getDate(){
			return $this->date;
		}
		
		public function setDate($date){
			$this->date = $date;
		}
		public function getSalary(){
			return $this->salary;
		}
		
		public function setSalary($salary){
			$this->salary = $salary;
		}

		public function setId($id){
			$this->id = $id;
		}

		public function getId(){
			return $this->id;
		}
		public function setImage($image){
			$this->image = $image;
		}

		public function getImage(){
			return $this->image;
		}

	}
?>