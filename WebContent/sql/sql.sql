CREATE  TABLE `springmvc`.`Employee` (

  `id` INT NOT NULL ,

  `lastName` VARCHAR(45) NULL ,

  `email` VARCHAR(45) NULL ,

  `gender` INT NULL ,

  `departid` INT NULL ,

  `birth` DATETIME NULL ,

  `salary` FLOAT NULL ,

  PRIMARY KEY (`id`) );

INSERT INTO `springmvc`.`employee` (`id`, `lastName`, `email`, `gender`, `departid`, `salary`) VALUES (1001, 'E-AA', 'aa@163.com', 1, 101, 3000);

INSERT INTO `springmvc`.`employee` (`id`, `lastName`, `email`, `gender`, `departid`) VALUES (1002, 'E-BB', 'bb@163.com', 1, 102);

INSERT INTO `springmvc`.`employee` (`id`, `lastName`, `email`, `gender`, `departid`) VALUES (1003, 'E-CC', 'cc@163.com', 0, 103);

INSERT INTO `springmvc`.`employee` (`id`, `lastName`, `email`, `gender`, `departid`) VALUES (1004, 'E-DD', 'dd@163.com', 0, 104);

INSERT INTO `springmvc`.`employee` (`id`, `lastName`, `email`, `gender`, `departid`) VALUES (1005, 'E-EE', 'ee@163.com', 1, 105);


CREATE  TABLE `springmvc`.`Department` (

  `id` INT NOT NULL ,

  `departmentName` VARCHAR(45) NULL ,

  PRIMARY KEY (`id`) );

INSERT INTO `springmvc`.`department` (`id`, `departmentName`) VALUES (101, 'D-AA');

INSERT INTO `springmvc`.`department` (`id`, `departmentName`) VALUES (102, 'D-BB');

INSERT INTO `springmvc`.`department` (`id`, `departmentName`) VALUES (103, 'D-CC');

INSERT INTO `springmvc`.`department` (`id`, `departmentName`) VALUES (104, 'D-DD');

INSERT INTO `springmvc`.`department` (`id`, `departmentName`) VALUES (105, 'D-EE');


  
  
 