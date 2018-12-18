(ns file-tree.core)

(def directory? (memfn ^java.io.File isDirectory))
(def list-files (memfn ^java.io.File listFiles))

(defn separate-dirs-from-files
  "Takes a vector of [(dirs) (files)] and a java.io.File
  Returns a vector of [(dirs) (files)] with the file added to dirs or files."
  [[dirs files] ^java.io.File file]
  (let [name (.getName file)]
    (if (directory? file)
      [(conj dirs name) files]
      [dirs (conj files name)])))

(defn build-file-tree
  "Takes a java file.
  Returns a vector of [path-str (dirnames) (filenames)]"
  [^java.io.File file]
  (vec (cons (str file)
             (reduce separate-dirs-from-files [() ()] (list-files file)))))

(defn walk-seq
  "Walks breadth-first down a file path returning a sequence of folder trees.
  Takes a string directory path or java file.
  Returns lazy seq of [path-str (dirnames) (filenames)]."
  [root-dir]
  (->> root-dir
       (clojure.java.io/file)
       (file-seq)
       (filter directory?)
       (map build-file-tree)))

;; Usage in a REPL
(comment
 (require '[file-tree.core :refer [walk-seq]])
 (take 3 (walk-seq ".")))
