CREATE TABLE fired_employee (
  fired_employee_id VARCHAR(36) PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  document VARCHAR(11) NOT NULL,
  occupation VARCHAR(255) NOT NULL,
  shutdown_date DATE NOT NULL,
  fulfilled_prior_notice BOOLEAN NOT NULL,
  reason_for_dismissal VARCHAR(26) NOT NULL,
  termination_amount DECIMAL NOT NULL
)