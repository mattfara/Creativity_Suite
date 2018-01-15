#BUNK DATA GENERATOR FOR CREATIVITY_SUITE-TEST

USE `Creativity_Suite-test`;

#TRUNCATION

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE `Ideas`;
TRUNCATE TABLE `Concepts`;
TRUNCATE TABLE `Values`;
TRUNCATE TABLE `Problems`;
TRUNCATE TABLE `Idea_Concepts`;
TRUNCATE TABLE `Idea_Problems`;
TRUNCATE TABLE `Idea_Values`;
TRUNCATE TABLE `Sessions`;
TRUNCATE TABLE `Session_Problems`;

SET FOREIGN_KEY_CHECKS = 1;



#IDEAS
INSERT INTO `Ideas` (`name`,`description`) VALUES ('square wheels','rather than using round wheels on vehicles, we use square ones');
INSERT INTO `Ideas` (`name`,`description`) VALUES ('headlight parking','parking is free so long as your headlights are left on');
INSERT INTO `Ideas` (`name`,`description`) VALUES ('cupholders on public buses',NULL);
INSERT INTO `Ideas` (`name`,`description`) VALUES ('free education','all levels of education are free');
INSERT INTO `Ideas` (`name`,`description`) VALUES ('very expensive education','costs for institutional education are increased dramatically');

#CONCEPTS
INSERT INTO `Concepts` (`name`,`description`) VALUES ('divergent wheel shapes','the usual circular wheel is changed to another shape');
INSERT INTO `Concepts` (`name`,`description`) VALUES ('self limiting parking','a finite aspect of vehicle function serves to limit time in public parking');
INSERT INTO `Concepts` (`name`,`description`) VALUES ('adding amenities to public buses',NULL);
INSERT INTO `Concepts` (`name`,`description`) VALUES ('changing cost of education',NULL); #should go to idea 4 and 5

#VALUES
INSERT INTO `Values` (`name`,`description`) VALUES ('different terrains accommodated',NULL);
INSERT INTO `Values` (`name`,`description`) VALUES ('people less likely overstay parking',NULL); #should go to idea 2
INSERT INTO `Values` (`name`,`description`) VALUES ('city saves money on meter maids',NULL); #should go to idea 2
INSERT INTO `Values` (`name`,`description`) VALUES ('bus is cleaner',NULL);
INSERT INTO `Values` (`name`,`description`) VALUES ('only people who value education can get it',NULL); ##should go to idea 4 and 5

#PROBLEMS
INSERT INTO `Problems` (`name`,`description`) VALUES ('innovation of the wheel',NULL);
INSERT INTO `Problems` (`name`,`description`) VALUES ('how can parking be less expensive',NULL);
INSERT INTO `Problems` (`name`,`description`) VALUES ('how can more people be attracted to the bus',NULL);
INSERT INTO `Problems` (`name`,`description`) VALUES ('how can education be more valuable in society',NULL);


#IDEA_CONCEPTS
INSERT INTO `Idea_Concepts` (`idea_id`,`concept_id`) VALUES('1','1');
INSERT INTO `Idea_Concepts` (`idea_id`,`concept_id`) VALUES('2','2');
INSERT INTO `Idea_Concepts` (`idea_id`,`concept_id`) VALUES('3','3');
INSERT INTO `Idea_Concepts` (`idea_id`,`concept_id`) VALUES('4','4');
INSERT INTO `Idea_Concepts` (`idea_id`,`concept_id`) VALUES('5','4');

#IDEA_PROBLEMS
INSERT INTO `Idea_Problems` (`idea_id`,`problem_id`) VALUES('1','1');
INSERT INTO `Idea_Problems` (`idea_id`,`problem_id`) VALUES('2','2');
INSERT INTO `Idea_Problems` (`idea_id`,`problem_id`) VALUES('3','3');
INSERT INTO `Idea_Problems` (`idea_id`,`problem_id`) VALUES('4','4');
INSERT INTO `Idea_Problems` (`idea_id`,`problem_id`) VALUES('5','4');

#IDEA_VALUES
INSERT INTO `Idea_Values` (`idea_id`,`value_id`) VALUES('1','1');
INSERT INTO `Idea_Values` (`idea_id`,`value_id`) VALUES('2','2');
INSERT INTO `Idea_Values` (`idea_id`,`value_id`) VALUES('2','3');
INSERT INTO `Idea_Values` (`idea_id`,`value_id`) VALUES('3','4');
INSERT INTO `Idea_Values` (`idea_id`,`value_id`) VALUES('4','5');
INSERT INTO `Idea_Values` (`idea_id`,`value_id`) VALUES('5','5');

#SESSIONS
INSERT INTO `Sessions` (`date`,`start_time`,`end_time`,`hat_sequence`) VALUES('2016-01-01','14:35:00','15:40:00', 'blue,white,white,red,green,yellow,black');
INSERT INTO `Sessions` (`date`,`start_time`,`end_time`,`hat_sequence`) VALUES('2016-02-02','15:40:00','16:45:00', NULL);
INSERT INTO `Sessions` (`date`,`start_time`,`end_time`,`hat_sequence`) VALUES('2017-03-03','16:45:00','17:00:00', 'blue,white,white,red,green,yellow,black');
INSERT INTO `Sessions` (`date`,`start_time`,`end_time`,`hat_sequence`) VALUES('2018-04-04','17:00:00','17:05:00', 'blue,white,white,red,green,yellow,black');

#SESSION_PROBLEMS
INSERT INTO `Session_Problems` (`session_id`,`problem_id`) VALUES('1','1');
INSERT INTO `Session_Problems` (`session_id`,`problem_id`) VALUES('2','2');
INSERT INTO `Session_Problems` (`session_id`,`problem_id`) VALUES('3','3');
INSERT INTO `Session_Problems` (`session_id`,`problem_id`) VALUES('4','4');
INSERT INTO `Session_Problems` (`session_id`,`problem_id`) VALUES('4','3');
INSERT INTO `Session_Problems` (`session_id`,`problem_id`) VALUES('4','2');


