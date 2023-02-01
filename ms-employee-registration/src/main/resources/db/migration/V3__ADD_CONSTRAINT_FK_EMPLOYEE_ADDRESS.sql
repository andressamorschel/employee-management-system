ALTER TABLE employee
ADD CONSTRAINT fk_employee_address
FOREIGN KEY (address_id)
REFERENCES address (address_id);