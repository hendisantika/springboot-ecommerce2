apt-get update && apt-get upgrade && apt-get autoremove
apt-get install default-jdk default-jre mysql-server maven
mysql_secure_installation
mysql
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
FLUSH PRIVILEGES;
