# wiki-map-reduce

Project to analyse data from https://dumps.wikimedia.org/other/pagecounts-raw/ with MapReduce approach 

Simply configure Gradle and use Gradle files provided.

To launch program type:

<b>cat <file_of_wikimedia_type> | java -jar Mapper.jar | sort | java -jar Reducer.jar | sort -nk 2 </b>
