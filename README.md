# sparrow
mysql、mybatis、springboot、spring mvc..

## 目录组织

| 新增 |                说明                                                                  |
|:-------|:---------------------------------------------------------------------------------|
| controller    | `rest服务`                                                   |
| datasource   | `使用aop实现数据源动态切换，方便多数据库集成以及读写分离场景`                      |
| domains  | `模型类定义`                                                  |
| mappers  | `mybatis映射器类`                                                  |
| service  | `服务层，实现业务逻辑、集成事务管理`                                                  |

## 读写分离业务场景
```java
@Service
public class UsersService {

    @Resource
    UsersRespository usersRepository;
    
    @DynamicDataSource(DynamicDataSourceType.master)
    public int insertlUser(){
        Users users = new Users();
        users.setName("王小二");
        users.setEmail("wxe@163.com");
        users.setTelephone("027-8888888");
        return this.usersRepository.insert(users);
    }

    @DynamicDataSource(DynamicDataSourceType.slave)
    public Users getUserById(Long id){
        return this.usersRepository.selectByPrimaryKey(id);
    }
}
```