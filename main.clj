;Marco Antonio Barbosa Zulian
;3. Utilizando a linguagem Clojure, crie uma função chamada elementoN que receba uma lista e um inteiro N e devolva o  elemento que  está na  posição N desta lista usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.  
(def elementoN
  (fn [n, arr]
    (cond
      (= n 1) (first arr)
      :else (elementoN (- n 1) (drop 1 arr)))))

(println "ElementoN 3 [1,2,3] = " (elementoN 3 [1,2,3]))
(println "ElementoN 2 (4,5,6) = " (elementoN 2 '(4,5,6)))
(println "ElementoN 1 (-2,0,1) = " (elementoN 1 '(-2,0,1)))

;1. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  ultimo  que  receba  uma  lista  e devolva o último elemento desta lista sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure. 
(def ultimo
  (fn [arr] (elementoN (count arr) arr)))
(println "Ultimo [1,2,3] = " (ultimo [1,2,3]))
(println "Ultimo (4,5,6) = " (ultimo '(4,5,6)))

;2. Utilizando a linguagem Clojure, crie uma função chamada penultimo que receba uma lista e  devolva  o  penúltimo  elemento  desta  lista  usar as  funções  já  prontas  e disponíveis para esta mesma finalidade na linguagem Clojure. 
(def penultimo
  (fn [arr] (elementoN (- (count arr) 1) arr)))
(println "Penultimo [1,2,3] = " (penultimo [1,2,3]))
(println "Penultimo (4,5,6) = " (penultimo '(4,5,6)))

;4. Utilizando  a  linguagem Clojure,  crie  uma função  chamada  inverso  que  receba uma  lista  e devolva esta lista com as posições dos elementos invertidas. Por exemplo recebe [1,2,3] e devolve [3,2,1]. Sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.  
(defn inverso [lista]
  (if (= (count lista) 0)
    []
    (conj (inverso (rest lista)) (elementoN 1 lista))
  )
)
(println "Inverso [1,2,3] = "(inverso [1,2,3]))
(println "Inverso (4,5,6) = "(inverso '(4,5,6)))

;5. Utilizando a  linguagem Clojure, crie uma função chamada  mdc que receba  dois inteiros e devolve o mínimo divisor comum entre eles.  Sem usar as funções já prontas e disponíveis para esta mesma finalidade na linguagem Clojure.  
(defn divisivel [n, i] (= (mod n i) 0))
(defn ismdc [n, m, i] (and (divisivel n i) (divisivel m i)))
(defn mdcAux [n, m, i] (if (ismdc n m i) i (mdcAux n m (+ 1 i))))

(defn mdc [n, m] (mdcAux n m 2))
(println "mdc 56 49" (mdc 56 49))