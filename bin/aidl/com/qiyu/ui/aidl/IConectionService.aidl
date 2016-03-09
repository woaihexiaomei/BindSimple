package com.qiyu.ui.aidl;
import com.qiyu.ui.aidl.IListenner;

interface IConectionService{

  void send(String msg);
  void recieve(String msg);
  void setOnChangeListenner(IListenner listenner);
}