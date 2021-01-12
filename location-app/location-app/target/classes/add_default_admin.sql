-----------------------
-- Insert default admin
-----------------------
INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `password`) VALUES (1, 'Admin', 'Admin', 'admin@admin.com', '$2a$10$F6cZMCHQXxR9asE3af5Y6udGibz2xGvbyPpVZQntC5I7xucGMFWli' /*Password1!*/);

-----------------------
-- Insert user_role
-----------------------
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 2);