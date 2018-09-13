package packages.providers.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventListenerProxy;
import java.util.List;

import packages.interfaces.IDataProvider;
import packages.models.HeroModel;
import packages.utils.Log;

public class Database implements IDataProvider
{
	private Statement _statement = null;

	public Database(String driver, String url, String dbName, String user, String password)
	{
		try
		{
			Class.forName(driver).newInstance();
		}

		catch (Exception exc)
		{
			Log.out(this, exc.getMessage());
		}
	}

	private Boolean runQuery(String sqlQuery)
	{
		try
		{
			this._statement.execute(sqlQuery);
			return (true);
		}
		catch (Exception exc)
		{
			Log.out(this, exc.getMessage());
		}
		return (false);
	}

	public List<HeroModel> getHeroList() {
		return null;
	}

	public Boolean insertHero(HeroModel hero) {
		return null;
	}

	public Boolean updateHero(HeroModel hero) {
		return null;
	}

	public Boolean deleteHero(HeroModel hero) {
		return null;
	}
}