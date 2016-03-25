(ns rna-transcription)

(def dna->rna {\C \G
               \G \C
               \A \U
               \T \A})

(defn transcribe [dna] (apply str (map dna->rna dna)))

(defn invalid-nucleotides []
  (throw (AssertionError. "Provided invalid nucleotide")))

(defn to-rna [dna]
  (let [transcribed (transcribe dna)]
    (if (= (count dna) (count transcribed))
      transcribed
      (invalid-nucleotides))))
