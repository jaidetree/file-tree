# File Tree
A Clojure library function for returning a lazy seq of breadth-first vectors of path name, sub-directories, and files.

```clj
["path/to/file" '("dirnames") '("filenames")]
```

Works similarly to Python's [os.walk](https://docs.python.org/3/library/os.html#os.walk) function.

[![Clojars Project](https://img.shields.io/clojars/v/jayzawrotny/file-tree.svg)](https://clojars.org/jayzawrotny/file-tree) [![Build Status](https://travis-ci.com/jayzawrotny/file-tree.svg?branch=master)](https://travis-ci.com/jayzawrotny/file-tree)

[![Clojars Project](http://clojars.org/jayzawrotny/file-tree/latest-version.svg)](http://clojars.org/jayzawrotny/file-tree)

## Installation

### Clojure deps.edn

Add the following to your deps.edn:

```clojure
{jayzawrotny/file-tree {:mvn/version "0.1.0"}}
```

### Leiningen

Add the following to your project.clj:

```clojure
[jayzawrotny/file-tree "0.1.0"]
```

## Usage

```clojure
(ns my-app.core
  (:require [file-tree.core :refer [walk-seq]]))

(->> "."
     (walk-seq)
     (take 5)
     (prn)

```

## Contributing

Pull requests and contributors are welcome :smile:

### REPL
Run the following code in your terminal to start an nREPL server with cider middleware.

```shell
clj -Arepl
```

### Testing

Run unit tests by executing the following command in your terminal:

```shell
clj -Atest:runner
```

## License

Copyright © 2018 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
