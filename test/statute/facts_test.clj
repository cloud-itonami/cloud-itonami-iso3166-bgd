(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest bgd-has-spec-basis
  (let [sb (facts/spec-basis "BGD")]
    (is (= 4 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "http") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["BGD" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["bgd.companies-act-1994"]
         (mapv :statute/id (facts/by-topic "BGD" :corporate-governance))))
  (is (= ["bgd.companies-act-1994"]
         (mapv :statute/id (facts/by-topic "BGD" :incorporation))))
  (is (= ["bgd.labour-act-2006"]
         (mapv :statute/id (facts/by-topic "BGD" :labor))))
  (is (= ["bgd.income-tax-act-2023"]
         (mapv :statute/id (facts/by-topic "BGD" :tax))))
  (is (= ["bgd.personal-data-protection-act-2026"]
         (mapv :statute/id (facts/by-topic "BGD" :data-protection))))
  (is (= ["bgd.personal-data-protection-act-2026"]
         (mapv :statute/id (facts/by-topic "BGD" :privacy))))
  (is (empty? (facts/by-topic "BGD" :investment)))
  (is (empty? (facts/by-topic "ATL" :tax))))
