/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcount;

/**
 *
 * @author dan
 */
import java.util.Properties;
import org.apache.log4j.Logger;
import org.workplicity.entry.User;
import org.workplicity.repos.mongo.Repository;
import org.workplicity.util.MongoHelper;
import org.workplicity.task.NetTask;

public class Accounts extends Repository
{
  private static final Logger logger = Logger.getLogger(Accounts.class);
  public static final String TITLE = "Accounts";
  public static final String KEY_USER_BASE = "system.user.";
  public static final String KEY_PASSWORD_BASE = "accounts.password.";
  public static final int ACCOUNT_ADMIN_ID = 0;
  public static final int ACCOUNT_SYSTEM_ID = 1;

	@Override
  public void init(Properties props)
    throws Exception
  {
    String dbName = props.getProperty("system.name");
    logger.info("ACCOUNTS init invoked for db = '" + dbName + "'");

    boolean populated = MongoHelper.isPopulated(dbName, "Accounts");
    logger.info("collection 'Accounts' populated =" + populated);

    if (populated) {
      return;
    }

    logger.info("populating collection 'Accounts'");
    int i = 0;
    while (true)
    {
      String key = "system.user." + i;

      String value = props.getProperty(key);

      logger.debug("property key " + key + " has value = " + value);

      if (value == null)
      {
        break;
      }

      String[] values = value.split(" +");

      String name = values[0];

      String passwd = values[1];

      String className = values[2];

      logger.debug("name=" + name + " passwd=" + passwd + " className=" + className);

//      Class aclass = Class.forName(className);

//      User user = (User)aclass.newInstance();
      User user = new User();
      user.setLogname(name);
      user.setPassword(passwd);

      MongoHelper.insert(user, dbName, "Accounts");

      logger.debug("user id = " + user.getId());

      i++;
    }

    logger.info("init done!");
  }
}
