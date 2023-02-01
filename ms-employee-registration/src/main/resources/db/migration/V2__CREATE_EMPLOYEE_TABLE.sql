CREATE TABLE employee (
  employee_id VARCHAR(255) NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  salary DECIMAL NOT NULL,
  gender VARCHAR(6) NOT NULL,
  contract_type VARCHAR(10) NOT NULL,
  document VARCHAR(11) NOT NULL,
  occupation VARCHAR(255) NOT NULL,
  admission_date DATE NOT NULL,
  birth_date DATE NOT NULL,
  address_id VARCHAR(255) NOT NULL
)
