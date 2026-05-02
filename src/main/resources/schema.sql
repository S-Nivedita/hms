CREATE DATABASE  IF NOT EXISTS `hms` ;
USE `hms`;
 
--
-- Table structure for table `admin`l
--

CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `updation_date` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
 
--
-- Table structure for table `appointment`
--
CREATE TABLE `appointment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `appointment_date` date DEFAULT NULL,
  `appointment_time` time DEFAULT NULL,
  `consultancy_fees` bigint DEFAULT NULL,
  `doctor_status` int NOT NULL,
  `posting_date` datetime(6) DEFAULT NULL,
  `updation_date` date DEFAULT NULL,
  `user_status` int NOT NULL,
  `doctor_id` bigint DEFAULT NULL,
  `specialization_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoeb98n82eph1dx43v3y2bcmsl` (`doctor_id`),
  KEY `FK86613v1yerg56q9hoi2ick68j` (`specialization_id`),
  KEY `FK7bo52i6usixwb7ira9l16y3bu` (`user_id`),
  CONSTRAINT `FK7bo52i6usixwb7ira9l16y3bu` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK86613v1yerg56q9hoi2ick68j` FOREIGN KEY (`specialization_id`) REFERENCES `doctor_specialization` (`id`),
  CONSTRAINT `FKoeb98n82eph1dx43v3y2bcmsl` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
) ;
 
--
-- Table structure for table `contact_queries`
--
 
CREATE TABLE `contact_queries` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `admin_remark` varchar(255) DEFAULT NULL,
  `contact_no` bigint DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `is_read` bit(1) DEFAULT NULL,
  `last_updation_date` datetime(6) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `posting_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
 
--
-- Table structure for table `doctor`
--
CREATE TABLE `doctor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contact_no` bigint DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `doctor_email` varchar(255) DEFAULT NULL,
  `doctor_fees` bigint DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updation_date` datetime(6) DEFAULT NULL,
  `specialization_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqu7q2v0ynvj860sj1v3fm28kk` (`specialization_id`),
  CONSTRAINT `FKqu7q2v0ynvj860sj1v3fm28kk` FOREIGN KEY (`specialization_id`) REFERENCES `doctor_specialization` (`id`)
) ;
--
-- Table structure for table `doctor_specialization`
 
CREATE TABLE `doctor_specialization` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` datetime(6) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `updation_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
--
-- Table structure for table `medical_history`
 
CREATE TABLE `medical_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blood_pressure` varchar(255) DEFAULT NULL,
  `blood_sugar` varchar(255) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `medical_prescription` varchar(255) DEFAULT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa2kl5eko3q0ly2ktdt2pratik` (`patient_id`),
  CONSTRAINT `FKa2kl5eko3q0ly2ktdt2pratik` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ;
 
--
-- Table structure for table `patient`
--
 
CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_date` datetime(6) DEFAULT NULL,
  `patient_age` int NOT NULL,
  `patient_contact_no` bigint NOT NULL,
  `patient_email` varchar(255) DEFAULT NULL,
  `patient_gender` varchar(255) DEFAULT NULL,
  `patient_medical_history` varchar(255) DEFAULT NULL,
  `patient_name` varchar(255) DEFAULT NULL,
  `updation_date` datetime(6) DEFAULT NULL,
  `doctor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmer5utvy1hiff7ovs6f4bjtnw` (`doctor_id`),
  CONSTRAINT `FKmer5utvy1hiff7ovs6f4bjtnw` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
) ;
 
--
-- Table structure for table `users`
--
 
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `reg_date` datetime(6) NOT NULL,
  `updation_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
);
 
-- Dump completed on 2026-04-27 12:25:29