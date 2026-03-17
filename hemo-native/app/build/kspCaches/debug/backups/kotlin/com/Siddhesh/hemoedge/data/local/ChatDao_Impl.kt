package com.Siddhesh.hemoedge.`data`.local

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.getTotalChangedRows
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ChatDao_Impl(
  __db: RoomDatabase,
) : ChatDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfChatEntity: EntityInsertAdapter<ChatEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfChatEntity = object : EntityInsertAdapter<ChatEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `chat_messages` (`id`,`role`,`message`,`createdAt`,`pending`) VALUES (nullif(?, 0),?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ChatEntity) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.role)
        statement.bindText(3, entity.message)
        statement.bindLong(4, entity.createdAt)
        val _tmp: Int = if (entity.pending) 1 else 0
        statement.bindLong(5, _tmp.toLong())
      }
    }
  }

  public override suspend fun insert(message: ChatEntity): Long = performSuspending(__db, false, true) { _connection ->
    val _result: Long = __insertAdapterOfChatEntity.insertAndReturnId(_connection, message)
    _result
  }

  public override fun observeAll(): Flow<List<ChatEntity>> {
    val _sql: String = "SELECT * FROM chat_messages ORDER BY createdAt ASC"
    return createFlow(__db, false, arrayOf("chat_messages")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfRole: Int = getColumnIndexOrThrow(_stmt, "role")
        val _columnIndexOfMessage: Int = getColumnIndexOrThrow(_stmt, "message")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _columnIndexOfPending: Int = getColumnIndexOrThrow(_stmt, "pending")
        val _result: MutableList<ChatEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ChatEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpRole: String
          _tmpRole = _stmt.getText(_columnIndexOfRole)
          val _tmpMessage: String
          _tmpMessage = _stmt.getText(_columnIndexOfMessage)
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          val _tmpPending: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfPending).toInt()
          _tmpPending = _tmp != 0
          _item = ChatEntity(_tmpId,_tmpRole,_tmpMessage,_tmpCreatedAt,_tmpPending)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun clear(): Int {
    val _sql: String = "DELETE FROM chat_messages"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
        getTotalChangedRows(_connection)
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
