package GameApi;


/**
* GameApi/AdminOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameServer.idl
* Tuesday, June 23, 2020 8:11:47 AM IST
*/

public interface AdminOperations 
{
  boolean adminSignIn (String username, String password, String ip);
  GameApi.Hashtable[] getPlayerStatus ();
  boolean suspendAccount (String username, String password, String adminip, String usernameToSuspend);
} // interface AdminOperations
