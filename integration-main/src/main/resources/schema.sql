CREATE TABLE IF NOT EXISTS article (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  color VARCHAR(50),
  size VARCHAR(20),
  price DECIMAL(10, 2),
  sold_out BOOLEAN,
  discount DECIMAL(10, 2)
);
