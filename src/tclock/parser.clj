(ns tclock.parser
  (:require [clojure.data.json :as json])
  (:import (java.time.format DateTimeFormatter)
           (java.time LocalDateTime)))

(def formatter (DateTimeFormatter/ofPattern "yyyyMMdd'T'HHmmss'Z'"))

(defn- datetime-reader [key value]
  (let [format #(LocalDateTime/parse % formatter)]
    (cond
      (= key :start) (format value)
      (= key :end) (format value)
      :else value)))

(defn parse-json [json-entry]
  (json/read-str json-entry :key-fn keyword :value-fn datetime-reader))

