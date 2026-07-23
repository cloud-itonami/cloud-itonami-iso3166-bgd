(ns marketentry.facts "Bangladesh market-entry catalog.")
(def catalog
  {"BGD" {:name "Bangladesh"
          :owner-authority "CPTU / e-GP"
          :legal-basis "Public Procurement Act / Rules"
          :national-spec "e-GP supplier registration + RJSC/TIN"
          :provenance "https://www.eprocure.gov.bd/"
          :required-evidence ["RJSC/TIN record" "e-GP registration record" "RJSC extract" "Authorized-representative record"]
          :rep-owner-authority "contracting authorities / CPTU"
          :rep-legal-basis "Bangladeshi legal entity registration typically required for e-GP awards"
          :rep-provenance "https://www.eprocure.gov.bd/"
          :corporate-number-owner-authority "RJSC / NBR"
          :corporate-number-legal-basis "Company registration / TIN"
          :corporate-number-provenance "https://www.roc.gov.bd/"}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
