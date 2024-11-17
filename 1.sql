-- Заполнение таблицы account
INSERT INTO account (account_name, balance, currency, status) VALUES
                                                                  ('Savings Account', 1500.50, 'USD', 'active'),
                                                                  ('Checking Account', 300.00, 'USD', 'active'),
                                                                  ('Business Account', 25000.75, 'EUR', 'inactive');

-- Заполнение таблицы category
INSERT INTO category (name, type) VALUES
                                      ('Food', 'Expense'),
                                      ('Utilities', 'Expense'),
                                      ('Salary', 'Income');

-- Заполнение таблицы client
INSERT INTO client (address, contact_info, created_at, name) VALUES
                                                                 ('123 Main St', 'client1@example.com', 1692259200, 'Client One'),
                                                                 ('456 Elm St', 'client2@example.com', 1692345600, 'Client Two');

-- Заполнение таблицы supplier
INSERT INTO supplier (address, contact_info, created_at, name) VALUES
                                                                   ('789 Oak St', 'supplier1@example.com', 1692432000, 'Supplier One'),
                                                                   ('101 Pine St', 'supplier2@example.com', 1692518400, 'Supplier Two');

-- Заполнение таблицы transaction
INSERT INTO transaction (amount, date, description, type, account_id, category_id, client_id, supplier_id) VALUES
                                                                                                               (100.00, 1692604800, 'Groceries', 'Expense', 1, 1, 1, NULL),
                                                                                                               (250.00, 1692691200, 'Electricity Bill', 'Expense', 1, 2, NULL, NULL),
                                                                                                               (3000.00, 1692777600, 'Monthly Salary', 'Income', 2, 3, NULL, NULL);

-- Заполнение таблицы payment
INSERT INTO payment (amount, method, payment_date, payment_status, transaction_id) VALUES
                                                                                       (100.00, 'Credit Card', 1692604800, 'Completed', 1),
                                                                                       (250.00, 'Bank Transfer', 1692691200, 'Pending', 2);

-- Заполнение таблицы user
INSERT INTO user (email, password_hash, role, username) VALUES
                                                            ('admin@example.com', 'hashedpassword1', 'admin', 'adminUser'),
                                                            ('accountant@example.com', 'hashedpassword2', 'accountant', 'accountantUser'),
                                                            ('user@example.com', 'hashedpassword3', 'user', 'normalUser');

-- Заполнение таблицы report
INSERT INTO report (end_date, generated_at, report_type, start_date, generated_by) VALUES
                                                                                       (1692864000, 1692950400, 'Monthly', 1690185600, 1),
                                                                                       (1693545600, 1693632000, 'Quarterly', 1687814400, 2);