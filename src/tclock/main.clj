(ns tclock.main
  (:require [tclock.parser :as parser]
            [clojure.string :as str])
  (:import (java.io BufferedReader))
  (:gen-class))

(defn -main []
  (doseq [ln (line-seq (BufferedReader. *in*))]
    (if (str/starts-with? ln "{")
      (println (parser/parse-json ln)))))
