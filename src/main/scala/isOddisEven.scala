

  object isOdd {
    def unapply(a: List[Int]): Option[List[Int]] = {
      val res:List[Int] =  a.filter(a => a % 2 != 0)

      if (res.length < 1) None else Some(res)
    }
  }

  object isEven {
    def unapply(a: List[Int]): Option[List[Int]] = {
      val res:List[Int] =  a.filter(a => a % 2 == 0)

      if (res.length < 1) None else Some(res)
    }
  }



