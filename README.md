# dl4j-0.0.3.3-examples

Setup Locally
-------------
Depending on your system and network setup, you may not have access to protected repositories used for some of the dependencies. If this is the case, you can get everything to run by using local maven cache. 

Install Canova locally:
	$ git clone git@github.com:kkalass/Canova.git
	$ cd Canova
	$ gradle install

Install ND4J locally:
	$ git clone git@github.com:kkalass/nd4j.git
	$ cd nd4j
	$ gradle install

On my system, I was not able to successfully compile deeplearning4j - the tests kept failing. But the non-snapshot version is available in the repositories.

Now, checkout the examples and build them!
	$ git clone git@github.com:kkalass/dl4j-0.0.3.3-examples.git
	$ cd dl4j-0.0.3.3-examples
	$ gradle build eclipse

