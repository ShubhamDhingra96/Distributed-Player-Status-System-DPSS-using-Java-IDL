package GameApi;


/**
* GameApi/hashHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameServer.idl
* Tuesday, June 23, 2020 8:11:46 AM IST
*/

public final class hashHolder implements org.omg.CORBA.portable.Streamable
{
  public GameApi.Hashtable value[] = null;

  public hashHolder ()
  {
  }

  public hashHolder (GameApi.Hashtable[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = GameApi.hashHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    GameApi.hashHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return GameApi.hashHelper.type ();
  }

}
