(ns scramblies.service.scramblies-test
  (:require [clojure.test :refer :all]
            [scramblies.service.scramblies :refer :all]))

(deftest scramblies-challenge

  (testing "Strings that"
    (testing "can be rearranged to match another"
      (is (= true (scramblies? "rekqodlww" "world")))
      (is (= true (scramblies? "cedewaraaossoqqyt" "codewars")))
      (is (= true (scramblies? "bbrunoa" "abruno"))))

    (testing "can't be rearranged to match another"
      (is (= false (scramblies? "abruno" "bbruno")))
      (is (= false (scramblies? "katas" "steak")))))

  )

(deftest scramblies-edge-cases

  (testing "Empty string cases should't throw exceptions"
    (is (= true (scramblies? "" "")))
    (is (= true (scramblies? "a" "")))
    (is (= false (scramblies? "" "b"))))

  (testing "Long strings match"
    (is (= true (scramblies? "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
                             "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"))))
  )
