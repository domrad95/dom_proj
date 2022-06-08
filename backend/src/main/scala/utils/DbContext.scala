package utils

object DbContext {

  val db = {
    import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
    import io.getquill._
    val pgDataSource = new org.postgresql.ds.PGSimpleDataSource()
    pgDataSource.setUser("postgres")
    pgDataSource.setPassword("postgres")
    val hikariConfig = new HikariConfig()
    hikariConfig.setDataSource(pgDataSource)
    new PostgresJdbcContext(CamelCase, new HikariDataSource(hikariConfig))
  }

  def initializeDbStructures(): Unit = {

  }
}