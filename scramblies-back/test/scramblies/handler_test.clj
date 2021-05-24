(ns scramblies.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [scramblies.handler :refer :all]))

(deftest test-app-routes
  (testing "testing main route is ok"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "ok"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))

(deftest test-scramblies-route

  (testing "testing scramblies simple strings that are rearrangeable"
    (let [response (app (mock/request :get "/scramblies?str1=cbruno&str2=brunoc"))]
      (is (= (:status response) 200))
      (is (= (:body response) "true"))))

  (testing "testing scramblies simple strings that are not rearrangeable"
    (let [response (app (mock/request :get "/scramblies?str1=bruno&str2=brunoc"))]
      (is (= (:status response) 200))
      (is (= (:body response) "false")))))