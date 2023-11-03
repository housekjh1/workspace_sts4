# workspace_sts4

> 스프링 부트 학습용 레포지터리입니다.

## 환경
https://spring.io/tools

lombok 추가 : sts4 설치 위치에 설치, 프로젝트 우클릭 - Maven - Update Project
https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.30
#### 디펜던시 후속추가
프로젝트 우클릭 > Spring > Add Starters<br/>
프로젝트 우클릭 > Maven > Update Project
### Maven Project pom.xml
#### Hibernate EntityManager
> [Hibernate EntityManager](https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager/5.6.15.Final)
#### H2 Database Engine
> [H2 Database Engine](https://mvnrepository.com/artifact/com.h2database/h2/2.2.224)
### Project > Configure > Convert > Maven Project
### Project > Properties > Project Facets > Convert to faceted form... > JPA Check & Apply
### QueryDSL
> <!--dependency-->
		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-jpa</artifactId>
			<version>5.0.0</version>
			<classifier>jakarta</classifier>
		</dependency>
		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-apt</artifactId>
			<version>5.0.0</version>
			<classifier>jakarta</classifier>
		</dependency>
### QueryDSL Plugin
> <!--plugin-->
		<plugin>
			<groupId>com.mysema.maven</groupId>
			<artifactId>apt-maven-plugin</artifactId>
			<version>1.1.3</version>
			<executions>
				<execution>
					<goals>
						<goal>process</goal>
					</goals>
					<configuration>
						<outputDirectory>
							target/generated-sources/annotations</outputDirectory>
						<processor>
							com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
					</configuration>
				</execution>
			</executions>
		</plugin>
## STS4 JSP 관련
### jstl & tomcat-embed-jasper
> <!--dependency-->
		<dependency>
			<groupId>jakarta.servlet.jsp.jstl</groupId>
			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
		</dependency>
		<dependency>
			<groupId>jakarta.servlet</groupId>
			<artifactId>jakarta.servlet-api</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.glassfish.web</groupId>
			<artifactId>jakarta.servlet.jsp.jstl</artifactId>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
### Help > Install New Software
- --All Available Sites--
- 'web' 검색 후 '%OSGi%' 하위 모든 항목 설치
