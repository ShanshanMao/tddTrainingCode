 # tddTraining
 
 ## SmartLockerRobotTest
 
 1. task: 
     - Given: SmartLockerRobot有2个容量为2的Locker
     - When: 存包
     - Then: 存进第一个Locker，并返回ticket
 1. task: 
     - Given: SmartLockerRobot有两个Locker，第一个Locker容量为5，第二个Locker容量2
     - When: 存包
     - Then: 存进第一个Locker，并返回ticket
 1. task: 
     - Given: SmartLockerRobot有两个Locker，第一个Locker容量为2，第二个Locker容量5
     - When: 存包
     - Then: 存进第二个Locker，并返回ticket
 1. task: 
     - Given: SmartLockerRobot有两个Locker，2个容量为1的Locker，已经存了两次包
     - When: 存包
     - Then: 存包失败，返回NoRoomException异常
 1. task: 
     - Given: SmartLockerRobot有两个Locker，已经成功存包一次，并且有一张有效Ticket
     - When: 取包
     - Then: 成功取回对应包
 1. task: 
     - Given: SmartLockerRobot有两个Locker，使用PrimaryLockerRobot成功存包获得ticket
     - When: 使用ticket在SmartLockerRobot取包
     - Then: 成功取得对应包
 1. task: 
     - Given: SmartLockerRobot有两个Locker，使用SmartLockerRobot成功存包获得ticket
     - When: 使用ticket在PrimaryLockerRobot取包
     - Then: 成功取得对应包
 1. task: 
     - Given: SmartLockerRobot有两个Locker
     - When: 使用无效ticket取包
     - Then: 取包失败，抛出InvalidTicketException异常
 1. task: 
     - Given: SmartLockerRobot有两个容量为2的Locker，已经存包3次
     - When: 存包
     - Then: 存包成功，并返回ticket