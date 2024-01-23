<?php

if (!defined('DB_SERVER')) {
    require_once("../initialize.php");
}

class DBConnection
{

    private $host = '';
    private $port = ''; // Assuming the default MySQL port
    private $username = '';
    private $password = '';
    private $database = '';

    public $conn;

    public function __construct()
    {

        if (!isset($this->conn)) {

            $this->conn = new mysqli($this->host . ':' . $this->port, $this->username, $this->password, $this->database);

            if ($this->conn->connect_error) {
                die('Cannot connect to the database server: ' . $this->conn->connect_error);
            }
        }
    }

    public function __destruct()
    {
        $this->conn->close();
    }
}
?>
