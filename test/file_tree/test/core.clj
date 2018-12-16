(ns file-tree.test.core
  (:require [file-tree.core :refer :all]
            [clojure.test :refer :all]
            [clojure.java.io :as io]))

(deftest separate-dirs-from-files-test
  (testing "separate-dirs-from-files"
    (testing "Adds a java.io.File file to files"
      (is (= (separate-dirs-from-files [() ()] (io/file "./core.clj"))
             [() '("core.clj")])))
    (testing "Adds a java.io.File dir to dirnames"
      (is (= (separate-dirs-from-files [() ()] (io/file "./test"))
             ['("test") ()])))))

(deftest build-file-tree-test
  (testing "build-file-tree"
    (testing "Takes a file and returns a vector tree"
      (with-redefs [separate-dirs-from-files (constantly [() ()])
                    list-files (constantly [])]
        (is (= (build-file-tree (io/file "."))
               ["." () ()]))))))

(comment
 (run-tests 'file-tree.test.core))
