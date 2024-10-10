insert into type(type_id, name) values (1,'PUSH_UP');
insert into type(type_id, name) values (2,'PULL_UP');
insert into type(type_id, name) values (3,'SQUAT');
insert into member(member_id, name, email, phone, password, created_date, updated_date, status) values (1,'Yong', 'ehfrhfo9494@naver.com','010-7111-7499','1007','2024-10-09T00:00:00','2024-10-09T00:00:10','Login')
insert into exercise (end_time,member_id,start_time,target_count,target_time,total_count,type_id,video_video_id,exercise_id) values ('2024-10-06T08:01:00',1,'2024-10-06T08:00:00',5,'00:01:00',2,1,NULL,1);
insert into detail (count,exercise_id,passed_time,pose_landmark_pose_landmark_id,detail_id) values (1,1,'2024-10-06T10:00:01',NULL,1);
insert into detail (count,exercise_id,passed_time,pose_landmark_pose_landmark_id,detail_id) values (2,1,'2024-10-06T10:00:05',NULL,2);
