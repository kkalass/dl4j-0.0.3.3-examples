package org.deeplearning4j.tsne;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.deeplearning4j.berkeley.Pair;
import org.deeplearning4j.models.embeddings.WeightLookupTable;
import org.deeplearning4j.models.embeddings.inmemory.InMemoryLookupTable;
import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.wordstore.VocabCache;
import org.deeplearning4j.plot.Tsne;
import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Created by agibsonccc on 9/20/14.
 */
public class TsneExample {

    public static void main(String[] args) throws Exception  {
    	File file = getFile(args);
        Tsne tsne = new Tsne.Builder().setMaxIter(10000)
                .learningRate(500).useAdaGrad(false)
                .normalize(false).usePca(false).build();
        Pair<WeightLookupTable,VocabCache> info = WordVectorSerializer.loadTxt(file);
        VocabCache cache = info.getSecond();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < cache.numWords(); i++)
            list.add(cache.wordAtIndex(i));
        InMemoryLookupTable l = (InMemoryLookupTable) info.getFirst();
        INDArray weights = l.getSyn0();
        
        tsne.plot(weights,2,list);
        
    }

	private static File getFile(String[] args) throws IOException {
		if (args.length == 0) {
			// File must be a serializd Word vector.
			// You may for example create this file by running Word2VecExample
	    	File f = new File("words.txt");
	    	if (!f.exists()) {
	    		System.out.println("To use the default serialized Word vector, run the Word2VecExample to let it create the file " + f.getPath());
	    		System.exit(1);
	    	}
	        return f;
		}
		return new File(args[0]);
	}



}
