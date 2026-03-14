# AGENTS.md - Development Guidelines

## Project Overview
Multi-module Spring Boot Maven project with demos for: MyBatis Plus, Neo4j, Redis, Netty, Zookeeper, Sentinel, Eureka, LiteFlow, Easy Rule, QLExpress, PF4J, Spring Gateway, OpenFeign, ShardingSphere, Security, MCP, Algorithms.

**Java**: 1.8 | **Spring Boot**: 2.7.7 | **Spring Cloud**: 2021.0.5

---

## Build & Test Commands

```bash
# Build all modules
mvn clean install

# Build without tests
mvn clean install -DskipTests

# Build single module
mvn clean install -pl mybatis-test

# Run app from module
mvn spring-boot:run -pl <module-name>
```

### Test Commands

```bash
# All tests in project
mvn test

# Tests in single module
mvn test -pl mybatis-test

# Specific test class
mvn test -Dtest=MybatisTestApplicationTests

# Specific test method
mvn test -Dtest=MybatisTestApplicationTests#contextLoads
```

---

## Code Style Guidelines

### Package & Class Naming
- Package: `com.johar.{module-name}` (e.g., `com.johar.mybatis.mybatistest`)
- Controller: `XxxController` | Service: `XxxService` | Interface: `IXxxService`
- PO/DO: `Xxx` | DTO: `XxxDTO` | BO: `XxxBO` | Enum: `XxxEnum`
- Config: `XxxConfig` | Util: `XxxUtils`

### Method Naming
- Get: `getXxx()`, query: `listXxx()/findXxx()`, save: `saveXxx()`
- Boolean: `isXxx()/hasXxx()/checkXxx()`

### Variables
- camelCase: `studentId`, `userName`
- Boolean: `isActive`, `hasError`
- Collections: `List<User> users`

### Imports (order: java > spring > 3rd party > project)
```java
import java.util.List;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johar.mybatis.mybatistest.po.Student;
```
**Avoid wildcard imports** (`import java.util.*`).

### Formatting
- 4 spaces indent (no tabs)
- Line length: <= 120 chars
- K&R braces
- Spaces around operators: `int x = a + b;`

### Annotations
Place on separate lines above class/method:
- `@Service`, `@Component`, `@Repository`
- `@RestController`, `@GetMapping`, `@PostMapping`, `@RequestMapping`
- `@Autowired`, `@Resource`, `@Transactional`, `@SentinelResource`

### Comments
Legacy code uses JavaDoc. **Do not add** unless requested.

---

## Error Handling

Use `BaseResult<T>` wrapper:
```java
return BaseResult.success(data);
return BaseResult.success();
return BaseResult.failed(ErrorCodeEnum.ERROR_CODE);
return BaseResult.failed(500, "Error message");
```
Use `@ControllerAdvice` for global exception handling (see `GlobalControllerAdvice`).

---

## Database - MyBatis Plus

```java
public class StudentService extends ServiceImpl<StudentMapper, Student> 
    implements IStudentService {
    // CRUD: save(), updateById(), removeById(), getById(), list()
}
```

Entity annotations:
```java
@Data
@TableName("table_name")
public class Student {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("user_name")
    private String userName;
}
```

---

## Testing

Tests in `src/test/java/`:
```java
@SpringBootTest
class XxxApplicationTests {
    @Test
    void contextLoads() {}
}
```

---

## Key Notes

1. **No linter/formatter** - Follow this document's guidelines
2. **Active module**: Only `netty-test` in root pom.xml modules
3. **Entry points**: Each module has `Application.java` with `@SpringBootApplication`
4. **Config**: `application.properties` or `application.yml` in `src/main/resources`

---

## Adding a New Module

1. Create `{module}/src/main/java/...`
2. Create `pom.xml` with Spring Boot parent
3. Add to root pom.xml `<modules>` or use `-pl` to build