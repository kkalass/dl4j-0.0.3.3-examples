# dl4j-0.0.3.3-examples

Setup Locally
-------------
Depending on your system and network setup, you may not have access to protected repositories used for some of the dependencies. If this is the case, you can get everything to run by using local maven cache. 

Install Canova locally:
  $ git clone git@github.com:kkalass/Canova.git
  $ cd Canova 
  $ # If it does not work, try: git checkout 4c5230df4cf97ca5d6d1b96488a7f3b8933c5422
  $ gradle install

Install ND4J locally:

  $ git clone git@github.com:kkalass/nd4j.git
  $ cd nd4j  
  $ # If it does not work, try: git checkout e6660152cbe60a3ad2ebd88cb602b281cc2b42f2
  $ gradle install

On my system, I was not able to successfully compile deeplearning4j - the tests kept failing. But the non-snapshot version is available in the repositories.

Now, checkout the examples and build them!
  $ git clone git@github.com:kkalass/dl4j-0.0.3.3-examples.git
  $ cd dl4j-0.0.3.3-examples
  $ # If it does not work, try: git checkout d97cdbe41b81581c452a42e2804f6f2143230c43
  $ gradle build eclipse

JCuda
-----
If you want to get rid of jcuda exceptions, install it from:

http://jcuda.org/downloads/downloads.html
