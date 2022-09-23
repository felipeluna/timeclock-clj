(ns tclock.main-test
  (:require [clojure.test :refer :all])
  (:require [tclock.parser :refer [parse-json]])
  (:import (java.time LocalDateTime)))

(deftest parse-json-test
  (let [expected {:id 1 :start (LocalDateTime/of 2022 9 23 18 32 56) :tags ["clojure"]}]
    (is (= expected (parse-json "{\"id\":1,\"start\":\"20220923T183256Z\",\"tags\":[\"clojure\"]}"))))  )
