package com.Siddhesh.hemoedge.`data`.local

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Float
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
public class ScanDao_Impl(
  __db: RoomDatabase,
) : ScanDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfScanEntity: EntityInsertAdapter<ScanEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfScanEntity = object : EntityInsertAdapter<ScanEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `scans` (`id`,`userId`,`patientName`,`riskScore`,`createdAt`,`notes`,`synced`) VALUES (nullif(?, 0),?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ScanEntity) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.userId)
        statement.bindText(3, entity.patientName)
        statement.bindDouble(4, entity.riskScore.toDouble())
        statement.bindLong(5, entity.createdAt)
        val _tmpNotes: String? = entity.notes
        if (_tmpNotes == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpNotes)
        }
        val _tmp: Int = if (entity.synced) 1 else 0
        statement.bindLong(7, _tmp.toLong())
      }
    }
  }

  public override suspend fun upsert(scan: ScanEntity): Long = performSuspending(__db, false, true) { _connection ->
    val _result: Long = __insertAdapterOfScanEntity.insertAndReturnId(_connection, scan)
    _result
  }

  public override fun observeAll(): Flow<List<ScanEntity>> {
    val _sql: String = "SELECT * FROM scans ORDER BY createdAt DESC"
    return createFlow(__db, false, arrayOf("scans")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfPatientName: Int = getColumnIndexOrThrow(_stmt, "patientName")
        val _columnIndexOfRiskScore: Int = getColumnIndexOrThrow(_stmt, "riskScore")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _columnIndexOfNotes: Int = getColumnIndexOrThrow(_stmt, "notes")
        val _columnIndexOfSynced: Int = getColumnIndexOrThrow(_stmt, "synced")
        val _result: MutableList<ScanEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ScanEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpUserId: String
          _tmpUserId = _stmt.getText(_columnIndexOfUserId)
          val _tmpPatientName: String
          _tmpPatientName = _stmt.getText(_columnIndexOfPatientName)
          val _tmpRiskScore: Float
          _tmpRiskScore = _stmt.getDouble(_columnIndexOfRiskScore).toFloat()
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          val _tmpNotes: String?
          if (_stmt.isNull(_columnIndexOfNotes)) {
            _tmpNotes = null
          } else {
            _tmpNotes = _stmt.getText(_columnIndexOfNotes)
          }
          val _tmpSynced: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfSynced).toInt()
          _tmpSynced = _tmp != 0
          _item = ScanEntity(_tmpId,_tmpUserId,_tmpPatientName,_tmpRiskScore,_tmpCreatedAt,_tmpNotes,_tmpSynced)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun observeRecent(limit: Int): Flow<List<ScanEntity>> {
    val _sql: String = "SELECT * FROM scans ORDER BY createdAt DESC LIMIT ?"
    return createFlow(__db, false, arrayOf("scans")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, limit.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfPatientName: Int = getColumnIndexOrThrow(_stmt, "patientName")
        val _columnIndexOfRiskScore: Int = getColumnIndexOrThrow(_stmt, "riskScore")
        val _columnIndexOfCreatedAt: Int = getColumnIndexOrThrow(_stmt, "createdAt")
        val _columnIndexOfNotes: Int = getColumnIndexOrThrow(_stmt, "notes")
        val _columnIndexOfSynced: Int = getColumnIndexOrThrow(_stmt, "synced")
        val _result: MutableList<ScanEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ScanEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpUserId: String
          _tmpUserId = _stmt.getText(_columnIndexOfUserId)
          val _tmpPatientName: String
          _tmpPatientName = _stmt.getText(_columnIndexOfPatientName)
          val _tmpRiskScore: Float
          _tmpRiskScore = _stmt.getDouble(_columnIndexOfRiskScore).toFloat()
          val _tmpCreatedAt: Long
          _tmpCreatedAt = _stmt.getLong(_columnIndexOfCreatedAt)
          val _tmpNotes: String?
          if (_stmt.isNull(_columnIndexOfNotes)) {
            _tmpNotes = null
          } else {
            _tmpNotes = _stmt.getText(_columnIndexOfNotes)
          }
          val _tmpSynced: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfSynced).toInt()
          _tmpSynced = _tmp != 0
          _item = ScanEntity(_tmpId,_tmpUserId,_tmpPatientName,_tmpRiskScore,_tmpCreatedAt,_tmpNotes,_tmpSynced)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
