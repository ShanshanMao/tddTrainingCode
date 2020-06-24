 # tddTraining
 
 ## SmartLockerRobot
 
 1. task: 
     - Given: SmartLockerRobot有2个可用容量为2的Locker
     - When: 存包
     - Then: 存进第一个Locker，并返回ticket
 1. task: 
     - Given: SmartLockerRobot有两个Locker，第一个Locker可用容量为5，第二个Locker可用容量2
     - When: 存包
     - Then: 存进第一个Locker，并返回ticket
 1. task: 
     - Given: SmartLockerRobot有两个Locker，第一个Locker可用容量为2，第二个Locker可用容量5
     - When: 存包
     - Then: 存进第二个Locker，并返回ticket
 1. task: 
     - Given: SmartLockerRobot有两个Locker，2个可用容量为1的Locker，已经存了两次包
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
     - Given: SmartLockerRobot有两个可用容量为2的Locker，已经存包3次
     - When: 存包
     - Then: 存包成功，并返回ticket
   
## LockerRobotManager

 1. task:
     - Given: Locker Robot Manager管理两个locker，且两个locker均有可用空间，Locker Robot Manager未管理robot
     - When: Locker Robot Manager存包
     - Then: 成功存入第1个locker，返回票据
 2. task:
     - Given: Locker Robot Manager管理两个locker，且第1个locker已满，第2个locker有空可用空间，Locker Robot Manager未管理robot
     - When: Locker Robot Manager存包
     - Then: 成功存入第2个locker，返回票据
 3. task:
     - Given: Locker Robot Manager管理两个locker，且两个locker均已满，Locker Robot Manager未管理robot
     - When: Locker Robot Manager存包
     - Then: 存包失败，提示储物柜已满
 4. task:
     - Given: Locker Robot Manager未管理locker，Locker Robot Manager管理两个robot，且两个robot管理的locker均有可用空间 
     - When: Locker Robot Manger存包
     - Then: 成功由第1个robot存入，返回票据
 5. task:
     - Given: Locker Robot Manager未管理locker， Locker Robot Manager管理两个robot，第1个robot的locker已满，第2个robot的locker有空用空间 
     - When: Locker Robot Manager存包
     - Then: 成功由第2个robot存入，返回票据
 6. task:
     - Given: Locker Robot Manager未管理locker，Locker Robot Manager管理两个robot，且两个robot管理的locker已满 
     - When: Locker Robot Manager存包
     - Then: 存包失败，提示储物柜已满
 7. task:
     - Given: Locker Robot Manager管理1个locker和1个robot，且均有可用空间 
     - When: Locker Robot Manager存包
     - Then: 成功由robot存入，返回票据
 8. task:
     - Given: Locker Robot Manager管理1个locker和1个robot，locker有可用空间，但robot的locker已满
     - When: Locker Robot Manager存包
     - Then: 成功存入locker，返回票据
 9. task:
     - Given: Locker Robot Manager管理1个locker和1个robot，且均已满 
     - When: Locker Robot Manager存包
     - Then: 存包失败，提示储物柜已满
 10. task:
     - Given: Locker Robot Manager管理2个locker，没有管理robot，且票据有效
     - When: Locker Robot Manager取包
     - Then: 取包成功
 11. task:
     - Given: Locker Robot Manager管理2个locker，没有管理robot，且票据无效
     - When: Locker Robot Manager取包
     - Then: 取包失败，提示无效票据
 12. task:
     - Given: Locker Robot Manager没有管理locker，且管理2个robot，且票据有效
     - When: Locker Robot Manager取包
     - Then: 取包成功
 13. task:
     - Given: Locker Robot Manager没有管理locker，且管理2个robot，且票据无效
     - When: Locker Robot Manager取包
     - Then: 取包失败，提示无效票据
 14. task:
     - Given: Locker Robot Manager管理1个locker和1个robot，且票据有效
     - When: Locker Robot Manager取包
     - Then: 取包成功
 15. task:
     - Given: Locker Robot Manager管理1个locker和1个robot，且票据无效
     - When: Locker Robot Manager取包
     - Then: 取包失败，提示无效票据
 16. task: 
     - Given: Locker Robot Manager管理1个locker和1个PrimaryLockerRobot，且票据有效
     - When: PrimaryLockerRobot取包
     - Then: 取包失败，提示无效票据
 17. task:
     - Given: Locker Robot Manager管理1个locker和1个SmartLockerRobot，且票据有效
     - when: SmartLockerRobot取包
     - Then: 取包失败，提示无效票据