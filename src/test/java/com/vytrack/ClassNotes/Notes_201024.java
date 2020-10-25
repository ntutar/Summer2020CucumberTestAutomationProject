package com.vytrack.ClassNotes;
/*
https://www.youtube.com/watch?v=v9ejT8FO-7I&list=PLrhzvIcii6GNjpARdnO4ueTUAVR9eMBpc

Today is October 24, 2020
    Agenda: Review of most recent topics.
      - POM (Page Object Model).
      - Singleton pattern.

        More  about design OOP patterns: https://www.youtube.com/watch?v=v9ejT8FO-7I&list=PLrhzvIcii6GNjpARdnO4ueTUAVR9eMBpc
     - Cucumber BDD
     - Creating of the new project that includes all these topics.
##################################################################
1. When start creating java project, we need to choose build automation tool first.
  - Maven
  - Gradle (mostly for android apps)
 we will go with a maven
 NOTE: As a JDK version, choose any latest version that you have available. We gonna use Java 8 here anyways.
 group id: com.cybertek
 project name: WebOrdersAutomationSummer2020
 artifact id: WebOrdersAutomationSummer2020
 artifact --> jar file
 Add dependencies:
   <dependencies>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.8.1</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>6.8.1</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>4.2.2</version>
        </dependency>
    </dependencies>
https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html
right click on the project name --> new -- file --> .gitignore
NOTE: we create separate git repositories for every project. Usually, developers project and testers projects are separately.
git init - we run this command only once per project. No need to run it twice. We run it to create git repository. After creating git repository we can start tracking changes in the project also commit this project to github.
routine steps:
git add .
git commit -m "commit message"
git push
git inti command creates .git folder that is hidden by default.
 git add . - prepare all files for the commit
 git commit -m "first commit" - take a snapshot of the project (capture changes)
 -m  - commit message. To explain what has changed since previous commit. Since it's a first commit message is a "first commit"
run git status to see what are the changes since last commit. If this command gives error, "it's not a git repository" it means that you missed "git init" part.
vfomiuk@vfomiuk WebOrdersAutomationSummer2020 % git status
On branch main
Your branch is up to date with 'origin/main'.
nothing to commit, working tree clean
nothing to commit, working tree clean - since last commit there was no changes in the code. If you add, edit, delete any files git will detect it immediately.
Your branch is up to date with 'origin/main'. - in git we can have multiple branches. Branch - it's like alternative version of the project. We can have as many as we need branches. There different git flows:
One of the popular interview questions is a git flows and git flow in your project.
 # bad git flow
    everybody is working within same branch (master/main)
 #typical git flow
    main/master
    then every tester working within his own branch. Changes are coming to master/main branch after pull request approval. In some project, for every opened pull request, CI server is running whole regression to make sure that changes that are coming in this pull request didn't break automation/existing test cases.
 #another git work flow
    master branch, for every new feature (test case) we create new branch. Same thing here can be applied about automatically executed tests to ensure that newly developed scripts didn't break existing automation scripts.
com.weborders.utils
red files - not tracked by git yet (not added or ignored)
https://www.tutorialspoint.com/design_pattern/design_pattern_overview.htm
singleton - single instance (one and only one object, me, myself and I)
rules:
- 1 private static instance (private static WebDriver driver = new ChromeDriver())
- private constructor
- public static getInstance method (getDriver())
public class Instance {
//object will be initialized when class is loaded
    private static Instance instance = new Instance();
    private Instance(){}
    public static Instance getInstance() {
    return instance;
    }
}
one of the implementations of singleton design pattern.
One of the implementations of this pattern calls "lazy initialization"
public class Instance {
//object will be initialized when getInstance() method is invoked (called)
    private static Instance instance;
    private Instance(){}
    public static Instance getInstance() {
    if(instance == null){
        instance = new Instance();
    }
    return instance;
    }
}
why why why... it's static ??? - because it's shared
why constructor is private ? - to prevent class instantiation (makes impossible object creation out of the class)
Driver class design in singleton / according to singleton design pattern.
Then, we need to design driver class according to singleton design pattern:
public class Driver {
    private static WebDriver driver;
    private Driver(){}
    public static WebDriver getDriver(){
    //if driver object doesn't exist yet - create it
        if(driver == null){
            String browser = ConfigurationReader.getProperty("browser");
            switch(browser){
                case "chrome":
                    WebDriverManager.chrome().setup();
                    driver = new ChromeDriver();
                break;
            }
        }
        return driver;
    }

}
to make this method work in multi-threading environment, we can make it thread safe:
public static WebDriver getDriver(){
    //if driver object doesn't exist yet - create it
        if(driver == null){
            synchronized(Driver.class){
                String browser = ConfigurationReader.getProperty("browser");
                switch(browser){
                    case "chrome":
                        WebDriverManager.chrome().setup();
                        driver = new ChromeDriver();
                    break;
                }
            }
        }
        return driver;
    }
we can also design logger class in singleton. This is not very popular design pattern in the development. Usually, you will meet it in test automation.
abstract classes supposed to be extended.
Q: Any difference between git add . and git add src?
. means add everything (prepare all files for the commit)
src - only src files and folder/sub-folders
#Create configuration.properties file
Steps: Right click on the project name  --> new --> file --> configuration.properties
create your first property:
browser=chrome
We gonna use it in the Driver class.
 Properties properties = new Properties();
            properties.load(new FileInputStream("configuration.properties"));
            String browser = properties.getProperty("browser");
earlier you find issue - easier debugging process.
Created ConfigurationReader class to read properties from the single file.
Since we are planning to design BDD framework (we already added Cucumber BDD) what are the components of typical BDD test automation framework?
    pages - to store page classes
        BasePage
    runners - to store cucumber runner classes
        CucumberRunner
    step_definitions - to store code implementation of bdd scenarios
        PageStepDefinitions
    utilities - to store Driver class, ConfigurationReader class, BrowserUtils class
break until 4 PM
*We don't want it happened inside a step definitions or test class*
LoginPage loginPage = new LoginPage();
loginPage.userNameElement = driver.findElemnt(By.xpath("//*[@value='username']"));
Noooooooooooooo for this:
Thread.sleep(3000)
loginPage.userNameElement.sendKeys("Tester");
Thread.sleep(3000)

 */
public class Notes_201024 {
}
