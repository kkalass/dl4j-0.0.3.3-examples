# dl4j-0.0.3.3-examples

Setup Locally
-------------
Depending on your system and network setup, you may not have access to protected repositories used for some of the dependencies. If this is the case, you can get everything to run by using local maven cache. 

Install Canova locally:

```bash
$ git clone git@github.com:kkalass/Canova.git
$ cd Canova 
$ # If it does not work, try: git checkout 4c5230df4cf97ca5d6d1b96488a7f3b8933c5422
$ gradle install
```

Install ND4J locally:

```bash
$ git clone git@github.com:kkalass/nd4j.git
$ cd nd4j  
$ # If it does not work, try: git checkout e6660152cbe60a3ad2ebd88cb602b281cc2b42f2
$ gradle install
```

On my system, I was not able to successfully compile deeplearning4j - the tests kept failing. But the non-snapshot version is available in the repositories.

Now, checkout the examples and build them!

```bash
$ git clone git@github.com:kkalass/dl4j-0.0.3.3-examples.git
$ cd dl4j-0.0.3.3-examples
$ # If it does not work, try: git checkout d97cdbe41b81581c452a42e2804f6f2143230c43
$ gradle build eclipse
```

JCuda
-----
If you want to get rid of jcuda exceptions, install cuda lib from:

https://developer.nvidia.com/cuda-downloads

On Ubuntu, if you use the repos:
```
$ sudo dpkg -i ~/Downloads/cuda-repo-ubuntu1410_7.0-28_amd64.deb
$ sudo apt-get update
$ # I needed to remove some stuff: sudo apt-get remove wine1.6 wine winetricks 
$ sudo apt-get install cuda-cudart-7-0 cuda-cublas-7-0 cuda-cublas-dev-7-0 nvidia-cuda-toolkit
```

Don't forget to restart your computer!

TSNE
----

words.txt Datei erzeugen:
```
Word2VecExample
```


coords.csv - 'plot' erzeugen:
```
TsneExample
```

Rendern mit gnuplot
===================
Datei in Gnuplot-Format übersetzen

```bash
$ tr  ',' '\t' > coords.dat < coords.csv
```

Datei in Gnuplot rendern:
```bash
$ gnuplot
set terminal pdf enhanced color size 100in,100in font "Arial,100"
set output "plot.pdf"
set autoscale
plot 'coords.dat' using  1:2 title 'title', '' using 1:2:3 with labels offset 0, char 1
unset output
```

Als Ergebnis hat man dann die PDF-Datei, in der man den ganzen Wertebereich sieht. 

Um etwas genauer reinzuzoomen, kann man yrange und xrange setzen. Der ganze Plotting-Code sieht dann so aus:

```bash
$ gnuplot
set terminal pdf enhanced color size 100in,100in font "Arial,100"
set output "plot-center.pdf"
set yrange [-1000 : 1000]
set xrange [-1000: 1000]
plot 'coords.dat' using  1:2 title 'title', '' using 1:2:3 with labels offset 0, char 1
unset output
```

