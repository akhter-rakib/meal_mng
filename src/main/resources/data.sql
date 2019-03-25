REPLACE INTO `user`(user_id, active, date_created,email,mobile_no,name,password) VALUES (1,1,NOW(),'rakibccj@gmail.com','01748141648','rakib','$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');
REPLACE INTO `role` VALUES (1,'ADMIN');
REPLACE INTO `role` VALUES (2,'MEAL_MEMBER');
REPLACE INTO `user_role` VALUES (1,1);