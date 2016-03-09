/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\workshop4\\BinderA\\src\\com\\qiyu\\ui\\aidl\\IConectionService.aidl
 */
package com.qiyu.ui.aidl;
public interface IConectionService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.qiyu.ui.aidl.IConectionService
{
private static final java.lang.String DESCRIPTOR = "com.qiyu.ui.aidl.IConectionService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.qiyu.ui.aidl.IConectionService interface,
 * generating a proxy if needed.
 */
public static com.qiyu.ui.aidl.IConectionService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.qiyu.ui.aidl.IConectionService))) {
return ((com.qiyu.ui.aidl.IConectionService)iin);
}
return new com.qiyu.ui.aidl.IConectionService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_send:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.send(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_recieve:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.recieve(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setOnChangeListenner:
{
data.enforceInterface(DESCRIPTOR);
com.qiyu.ui.aidl.IListenner _arg0;
_arg0 = com.qiyu.ui.aidl.IListenner.Stub.asInterface(data.readStrongBinder());
this.setOnChangeListenner(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.qiyu.ui.aidl.IConectionService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void send(java.lang.String msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(msg);
mRemote.transact(Stub.TRANSACTION_send, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void recieve(java.lang.String msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(msg);
mRemote.transact(Stub.TRANSACTION_recieve, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setOnChangeListenner(com.qiyu.ui.aidl.IListenner listenner) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listenner!=null))?(listenner.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_setOnChangeListenner, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_send = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_recieve = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setOnChangeListenner = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void send(java.lang.String msg) throws android.os.RemoteException;
public void recieve(java.lang.String msg) throws android.os.RemoteException;
public void setOnChangeListenner(com.qiyu.ui.aidl.IListenner listenner) throws android.os.RemoteException;
}
