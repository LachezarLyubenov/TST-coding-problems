# TST-coding-problems


Project that solves 2 coding problems provided by the TST team
## Run Locally

Clone the project

```bash
  git clone https://github.com/LachezarLyubenov/TST-coding-problems.git
```

Go to the project directory and ensure you are on Master branch

```bash
  cd TST-coding-problems
```

Install dependencies -- primary Scala and SBT need to be installed on the machine.


Run the application. 

```bash
  sbt run
```
This will prompt you to choose problem1/problem2
## Running Tests

To run tests, run the following command

Run the test suite for problem1/problem2

```bash
  sbt "testOnly problem1.*"
```
or
```bash
  sbt "testOnly problem2.*"
```
or full test suite:
```bash
  sbt test
```
