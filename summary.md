# 부스트코스 - 웹 프로그래밍(FullStack)

# FrontEnd







# BackEnd



## Part 1



## Part 2

- JSP
- Sevlet
- Scope
- JSTL&EL
- MySQL
- SQL
- Maven
- JDBC
- WEB API





## Maven



### 1. Maven 이란?

1. Maven 이란?

   - 애플리케이션을 개발하기 위해 반복적으로 진행해왔던 작업들을 지원하기 위한 도구
   - 빌드(Build), 패키징, 문서화, 테스트와 테스트 리포팅, git, 의존성관리, 배포등의 작업을 손쉽게 할 수 있다.

2. CoC(Convetion over Configuration) 이란?

   - 일종의 관습
   - 예) 프로그램의 소스파일은 어떤 위치에 있어야 하고, 소스가 컴파일된 파일들은 어떤 위치에 있어야 하는지에 대해 미리 정해놓는 것

3. Maven의 이점

   - 의존성 라이브러리 관리
   - 다양한 플러그인을 제공하여, 많은 일들을 자동화 시킬 수 있다.

4. pox.xml

   - project: pom.xml 파일의 최상위 root element
   - modelVersion: POM model의 버전
   - groupId: 프로젝트를 생성하는 조직의 고유 아이디를 결정, 일반적으로 도메인 이름을 거꾸로 적는다.
   - artifactId: 해당 프로젝트에 의하여 생성되는 artifact의 고유 아이디를 결정한다. 
     - Maven을 이용하여 pom.xml을 빌드할 경우 artifactId-version.packaging 같은 규칙으로 artifact가 생성된다.
   - packaging: 해당 프로젝틀 어떤 형태로 packaging 할 것인지 결정한다. jar, war, ear 등이 해당된다.
   - version: 프로젝트의 현재 버전. 
     - 개발중에는 SNAPSHOT을 접미사로 사용
     - Maven의 버전 관리 기능은 라이브러리 관리를 편하게 한다.
   - name: 프로젝트의 이름입니다.
   - url: 프로젝트 사이트가 있다면 URL을 등록할 수 있다.

   - dependencies: 의존성 관리

![pom-xml](./img/pox-xml.png)



### 2. Maven을 이용한 웹 어플리케이션 실습



1. Maven 프로젝트 생성하기

   - File - New - Project - Maven - Maven Project
   - 아키타입(Archetype)선택
   - 아키타입(Archetype)이란? **일종의 프로젝트 템플릿, 어떤 아키타입을 선택했느냐에 따라서 자동으로, 여러 가지 파일들을 생성하거나 라이브러리를 셋팅해주는 등의 일을 함**
   - 웹 어플리케이션 개발을 위해서 maven-archetype-webapp을 선택
   - groupId, artifactId, version 등 입력
   - 프로젝트 생성 완료

   

2. Maven 프로젝트 디렉터리 구조

   - **src**
   - src/main/java: java 소스 파일
   - src/main/resources: *.properties, *.xml 등 설정파일들이 위치한다.
   - src/main/webapp: html,css 등 웹 어플리케이션과 관련된 소스
   - src/test/java: Test와 관련된 자바 패키지와 소스코드가 위치한다.
   - src/test/resources: 테스트와 관련된 설정파일들이 위치한다.
   - **target**: 컴파일, 패키징된 결과물이 위치한다.
   - **pom.xml**: Maven 설정파일

   ![maven-directory-structure](./img/maven-directory-structure.png)

   

3. Maven 프로젝트 Properties 설정

   - 프로젝트 우클릭 - properties 선택
   - Java Comiler 메뉴 선택(기본적으로 JDK 1.5버전을 사용하는 것을 확인 할 수 있음)
   - JDK8을 사용하도록 Maven 설정 파일(pom.xml) 파일 수정(Buid 태그부분 새롭게 추가)

   ```xml
   <!-- Junit이 기본적으로 의존성 추가 되어 있음 -->
   <dependencies>
     <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>3.8.1</version>
       <scope>test</scope>
     </dependency>
   </dependencies>
   <build>
       <finalName>mavenweb</finalName>
           <plugins>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-compiler-plugin</artifactId>
               <version>3.6.1</version>
               <configuration>
                   <source>1.8</source>
                   <target>1.8</target>
               </configuration>
           </plugin>
       </plugins>
     </build>
   ```

   - 다시, properties 선택 후 Java EE Intergration 선택
   - Enable Project Specific Settings 체크박스 선택
   - Apply and Close 클릭
   - 위 과정은, Maven의 설정을 바꾸고, 이클립스 프로젝트 설정이 연동 되도록 하는 과정임

   

4. Maven 프로젝트에서 Servlet 라이브러리 사용하기

   - Dynamic Web Application을 만들 때는 WAS Runtime 설정 하면서 Tomcat을 지정함.
   - WAS Runtime이 지정되면 Tomcat에 있는 라이브러리를 이클립스에서 사용할 수 있다.
   - 즉, Tomcat 안에 있는 Servelt 라이브러리를 사용하게되어 문제가 안생김.
   - 하지만, Maven 프로젝트 생성시, WAS Runtime이 지정을 안 했기 때문에 서블릿 라이브러리를 찾을 수 없음
   - 그래서, dependency를 추가해야함

   ```xml
   <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>javax.servlet-api</artifactId>
       <version>3.1.0</version>
       <scope>provided</scope>
   </dependency>
   ```

   - <scope> provided라는 항목: servlet 라이브러리를 컴파일 시에만 사용되고, 배포 시에는 사용되지 않는다는 것을 의미

5. <scope> 태그
   - compile: 컴파일 할 때 필요. 테스트 및 런타임에도 classpath에 포함됨. 기본값임
   - runtime: 런타임에 필요.  컴파일 시에는 필요하지 않지만, 실행 시에는 필요한 경우.(예, JDBC 드라이브)
   - provided: 컴파일시에 필요하지만, 실제 런타임 때에는 컨테이너 같은 것에서 제공되는 모듈이라 불필요.(servlet, jsp api등이 이에 해당됨). 즉, 배포시에 제외됨.
   - test: 테스트 코드를 컴파일 할 때 필요. 테스트시 classpath에 포함되며, 배포 시 제외됨



6. 프로젝트 실행

   - Maven 프로젝트 우클릭 - Run As - Run on Server
   - Always use this server when running this project를 클릭.

   

7. JSTL 라이브러리 의존성 추가하기

   - JSTL은 Tomcat이 기본으로 제공하지 않기 때문에, 컴파일할 때도 배포할 때도 사용돼야 한다.
   - 그래서, 기본 scope 사용

   ```xml
   <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>jstl</artifactId>
       <version>1.2</version>
   </dependency>
   ```

   - 다시 Run on server를 해도 아무것도 나오지 않음
   - Maven 프로젝트 우클릭 -> properties -> Project facets 항목을 보면, 다이나믹 웹 모듈 버전 2.3을 확인 할 수 있음
   - 다이나믹 웹 모듈 2.4 부터 EL이 기본으로 사용할 수 있도록 설정 되기 때문에, 3.1 버전이 되록 설정 변경

   ```xml
   <!-- /WEB-INF/web.xml -->
   <!-- 이 설정을 -->
   <web-app>
     <display-name>Archetype Created Web Application</display-name>
   </web-app>
   
   <!-- 이 설정으로 변경 -->
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
   xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
   version="3.1">
     <display-name>Archetype Created Web Application</display-name>
   </web-app>
   ```

   - ./settings/org.eclipse.wst.common.project.acet.core.xml 파일을 아래와 같이 수정

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <faceted-project>
     <fixed facet="wst.jsdt.web"/>
     <installed facet="jst.web" version="3.1"/>
     <installed facet="wst.jsdt.web" version="1.0"/>
     <installed facet="java" version="1.8"/>
   </faceted-project>
   ```



8. 이클립스 버그로 오류가 나는 경우, 웹 어플리케이션을 깔끔하게 초기화하고 실행
   - 기존 tomcate을 종료
   - Maven 프로젝트 우클릭 -> Maven -> update project 선택
   - Servers view에서 기존 Tomcat Runtime 삭제
   - Project 메뉴의 Clean 선택
   - 프로젝트 익스플로러에서 Server 삭제
   - Run on Server 재실행



## JDBC



### 1. JDBC란?

1. JDBC(Java Database Connectivity) 개요

   - Java를 이용한 데이터베이스 접속과 SQL 문장의 살행, 그리고 결과로 얻어진 데이터의 핸들링을 제공하는 방법과 절차에 관한 규약
   - Java 프로그램 내에서 SQL문을 실행하기 위한 JAVA API
   - Java는 표준 인터페이스인 JDBC API를 제공
   - 데이터베이스 벤더 또는 서드파티에서는 JDBC 인터페이스를 구현한 드라이버(driver) 제공

   

2. JDBC 환경 구성

   - JDK 설치
   - JDBC 드라이버 설치
   - Maven에서는 당므과 같이 의존성을 추가해서 사용할 수 있다.

   ```xml
   <dependency>   
       <groupId>mysql</groupId>   
       <artifactId>mysql-connector-java</artifactId>
       <version>5.1.45</version>
   </dependency>
   ```



3. JDBC를 이용한 프로그래밍 방법

   - import java.sql.*;

   ```java
   import java.sql.*;
   ```

   - 드라이브 로드

   ```java
   Class.forName( "com.mysql.jdbc.Driver" );
   ```

   - Connection 객체 생성

   ```java
   String dburl  = "jdbc:mysql://localhost/dbName";
   Connection con =  DriverManager.getConnection ( dburl, ID, PWD );
   ```

   - Statement 객체를 생성 및 질의 수행

   ```java
   Statement stmt = con.createStatement();
   ```

   - SQL 문에 결과물이 있다면 ResultSet 객체를 생성

   ```java
   ResultSet rs =  stmt.executeQuery( "select no from user" );
   while ( rs.next() )
         System.out.println( rs.getInt( "no") );
   
   //참고
   stmt.execute(“query”); //any SQL
   stmt.executeQuery(“query”); //SELECT
   stmt.executeUpdate(“query”); //INSERT, UPDATE, DELETE
   ```

   - 모든 객체를 역순으로 닫는다.(ResultSet -> Statement -< Connetcion)

   ```java
   rs.close();
   stmt.close();
   con.close();
   ```

   

   ![jdbc-class](./img/jdbc-class.png)

- 매번, 객체를 연결하고 닫는 코드가 반복적으로 발생
- 이 문제를 해결하기 위해서 Spring이 제공하는 JDBC API를 사용하여 간결하게 코드를 구성할 수 있다.



### 2. JDBC 실습

1. DTO

   - Getter/Setter/toSring 구현

   ```java
   package kr.or.connect.jdbcexam.dto;
   
   public class Role {
   	private Integer roleId;
   	private String description;
   
   	public Role() {}
   
   	public Role(Integer roleId, String description) {
   		super();
   		this.roleId = roleId;
   		this.description = description;
   	}
   
   	public Integer getRoleId() {
   		return roleId;
   	}
   
   	public void setRoleId(Integer roleId) {
   		this.roleId = roleId;
   	}
   
   	public String getDescription() {
   		return description;
   	}
   
   	public void setDescription(String description) {
   		this.description = description;
   	}
   
   	@Override
   	public String toString() {
   		return "Role [roleId=" + roleId + ", description=" + description + "]";
   	}
   }
   ```



2. DAO

   - Connection 객체 생성: 데이터베이스에 연결해서 요청/응답을 받기 위한 객체
   - PreparedStatment 객체 생성: query 사용시 ?에 값 바인딩 하는 등의 기능 제공
   - ResultSet: query의 결과, 테이블 row를 배열 형태로 받아옴
   - try/catch/finally: 에러처리

   

   - 1) 조회(getRole): 원하는 Role 객체를 테이버에스에서 가져옴

   ```java
   package kr.or.connect.jdbcexam.dao;
   
   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.PreparedStatement;
   import java.sql.ResultSet;
   import java.sql.SQLException;
   
   import kr.or.connect.jdbcexam.dto.Role;
   
   public class RoleDao {
   	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
   	private static String dbUser = "connectuser";
   	private static String dbpasswd = "connect123!@#";
   	
     //Role 가져오기
   	public Role getRole(Integer roleId) {
   		Role role = null;
   		Connection conn = null;
   		PreparedStatement ps = null;
   		ResultSet rs = null;
   
   		try {
   			Class.forName("com.mysql.jdbc.Driver");
   			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
   			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
   			ps = conn.prepareStatement(sql);
   			ps.setInt(1, roleId);
   			rs = ps.executeQuery();
   
   			if (rs.next()) {
   				String description = rs.getString(1);
   				int id = rs.getInt("role_id");
   				role = new Role(id, description);
   			}
   		} catch (Exception e) {
   			e.printStackTrace();
   		} finally {
   			if (rs != null) {
   				try {
   					rs.close();
   				} catch (SQLException e) {
   					e.printStackTrace();
   				}
   			}
   			if (ps != null) {
   				try {
   					ps.close();
   				} catch (SQLException e) {
   					e.printStackTrace();
   				}
   			}
   			if (conn != null) {
   				try {
   					conn.close();
   				} catch (SQLException e) {
   					e.printStackTrace();
   				}
   			}
   		}
   
   		return role;
   	}
       
   }
   ```

   

   - 2)  입력(addRole): 원하는 Role 객체를 데이터베이스에 입력

   ```java
   //Role 입력
   public int addRole(Role role) {
   		int insertCount = 0;
   
   		try {
   			Class.forName("com.mysql.jdbc.Driver");
   		} catch (ClassNotFoundException e) {
   			e.printStackTrace();
   		}
   		String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";
   
   		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
   				PreparedStatement ps = conn.prepareStatement(sql)) {
   
   			ps.setInt(1, role.getRoleId());
   			ps.setString(2, role.getDescription());
   
   			insertCount = ps.executeUpdate();
   
   		} catch (Exception ex) {
   			ex.printStackTrace();
   		}
   		return insertCount;
   	}  
   ```

   

   - 3) 수정(updateRole): 원하는 Role 객체의 filed를 수정한다.

   ```java
   public int updateRole(Role role) {
   		int updateCount = 0;
   		
   		Connection conn = null;
   		PreparedStatement ps = null;
   		
   		try {
   			Class.forName( "com.mysql.jdbc.Driver" );
   			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
   			String sql = "update role set description = ? where role_id = ?";
   		
   			ps = conn.prepareStatement(sql);	
   			ps.setString(1, role.getDescription());
   			ps.setInt(2,  role.getRoleId());
   			
   			updateCount = ps.executeUpdate();
   
   		}catch(Exception ex) {
   			ex.printStackTrace();
   		}finally {
   			if(ps != null) {
   				try {
   					ps.close();
   				}catch(Exception ex) {}
   			} // if
   			
   			if(conn != null) {
   				try {
   					conn.close();
   				}catch(Exception ex) {}
   			} // if
   		} // finally
   		
   		return updateCount;
   	}
   ```

   

   - 4) 삭제(deleteRole): 원하는 Role 객체를 데이터베이스에서 삭제한다.

   ```java
   public int deleteRole(Integer roleId) {
   		int deleteCount = 0;
   		
   		Connection conn = null;
   		PreparedStatement ps = null;
   		
   		try {
   			Class.forName( "com.mysql.jdbc.Driver" );			
   			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );			
   			String sql = "DELETE FROM role WHERE role_id = ?";
   
   			ps = conn.prepareStatement(sql);
   			ps.setInt(1,  roleId);
   			deleteCount = ps.executeUpdate();
   
   		}catch(Exception ex) {
   			ex.printStackTrace();
   		}finally {
   			if(ps != null) {
   				try {
   					ps.close();
   				}catch(Exception ex) {}
   			} // if
   			
   			if(conn != null) {
   				try {
   					conn.close();
   				}catch(Exception ex) {}
   			} // if
   		} // finally
   
   		return deleteCount;
   	}
   ```

   

   - 5) 여러개 조회(getRoles): 원하는 조건의 Role 객체를 여러개 가져온다.

   ```java
   public List<Role> getRoles() {
   		List<Role> list = new ArrayList<>();
   
   		try {
   			Class.forName("com.mysql.jdbc.Driver");
   		} catch (ClassNotFoundException e) {
   			e.printStackTrace();
   		}
   
   		String sql = "SELECT description, role_id FROM role order by role_id desc";
   		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
   				PreparedStatement ps = conn.prepareStatement(sql)) {
   
   			try (ResultSet rs = ps.executeQuery()) {
   
   				while (rs.next()) {
   					String description = rs.getString(1);
   					int id = rs.getInt("role_id");
   					Role role = new Role(id, description);
   					list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
   				}
   			} catch (Exception e) {
   				e.printStackTrace();
   			}
   		} catch (Exception ex) {
   			ex.printStackTrace();
   		}
   		return list;
   	}
   ```

   







