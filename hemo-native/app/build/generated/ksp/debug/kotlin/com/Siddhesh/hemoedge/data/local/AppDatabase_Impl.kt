package com.Siddhesh.hemoedge.`data`.local

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class AppDatabase_Impl : AppDatabase() {
  private val _scanDao: Lazy<ScanDao> = lazy {
    ScanDao_Impl(this)
  }

  private val _chatDao: Lazy<ChatDao> = lazy {
    ChatDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(1, "36fe597397c4ab384d33db9d4a2dfde9", "f05c0c6365ba8ddb9f5a05deb477241a") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `scans` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT NOT NULL, `patientName` TEXT NOT NULL, `riskScore` REAL NOT NULL, `createdAt` INTEGER NOT NULL, `notes` TEXT, `synced` INTEGER NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `chat_messages` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `role` TEXT NOT NULL, `message` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `pending` INTEGER NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '36fe597397c4ab384d33db9d4a2dfde9')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `scans`")
        connection.execSQL("DROP TABLE IF EXISTS `chat_messages`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection): RoomOpenDelegate.ValidationResult {
        val _columnsScans: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsScans.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScans.put("userId", TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScans.put("patientName", TableInfo.Column("patientName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScans.put("riskScore", TableInfo.Column("riskScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScans.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScans.put("notes", TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsScans.put("synced", TableInfo.Column("synced", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysScans: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesScans: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoScans: TableInfo = TableInfo("scans", _columnsScans, _foreignKeysScans, _indicesScans)
        val _existingScans: TableInfo = read(connection, "scans")
        if (!_infoScans.equals(_existingScans)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |scans(com.Siddhesh.hemoedge.data.local.ScanEntity).
              | Expected:
              |""".trimMargin() + _infoScans + """
              |
              | Found:
              |""".trimMargin() + _existingScans)
        }
        val _columnsChatMessages: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsChatMessages.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("role", TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("message", TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("createdAt", TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsChatMessages.put("pending", TableInfo.Column("pending", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysChatMessages: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesChatMessages: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoChatMessages: TableInfo = TableInfo("chat_messages", _columnsChatMessages, _foreignKeysChatMessages, _indicesChatMessages)
        val _existingChatMessages: TableInfo = read(connection, "chat_messages")
        if (!_infoChatMessages.equals(_existingChatMessages)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |chat_messages(com.Siddhesh.hemoedge.data.local.ChatEntity).
              | Expected:
              |""".trimMargin() + _infoChatMessages + """
              |
              | Found:
              |""".trimMargin() + _existingChatMessages)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "scans", "chat_messages")
  }

  public override fun clearAllTables() {
    super.performClear(false, "scans", "chat_messages")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(ScanDao::class, ScanDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(ChatDao::class, ChatDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>): List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun scanDao(): ScanDao = _scanDao.value

  public override fun chatDao(): ChatDao = _chatDao.value
}
